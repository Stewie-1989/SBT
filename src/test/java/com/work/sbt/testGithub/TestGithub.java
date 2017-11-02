package com.work.sbt.testGithub;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Response;
import com.work.sbt.testGithub.pojoclass.Follow;
import com.work.sbt.testGithub.pojoclass.User;
import com.work.sbt.testGithub.pojoclass.event.Event;
import com.work.sbt.testGithub.pojoclass.repository.Repository;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class TestGithub
{

    // Токен для авторизации на сайте github
    private final static String TOKEN = "1d33fbaf96c8e35942d338a443f03e1def7cb204";

    // Путь ко всем юзерам
    private final static String PATH_USERS = "https://api.github.com/users";

    // Путь ко всем репозиториям Stewie-1989
    private final static String PATH_REPOSITORY_STEWIE = "https://api.github.com/repos/Stewie-1989/";

    // Путь к репозиториям аторизированного юзера
    private final static String PATH_REPOSITORY_USER = "https://api.github.com/user/repos";

    // название репозитория
    private final static String NAME_REPOSITORY = "blog";

    // Тело отправляемого запроса
    private final static String DATA = "{ " +
                                        "\"name\": \""+ NAME_REPOSITORY+"\"," +
                                        " \"auto_init\": true," +
                                        "\"private\": false," +
                                        " \"gitignore_template\" : \"nanoc\" " +
                                        "}";


    /**
     * Получения корректных данных о пользователе
     */
    @Test
    @Description("Correct data about user")
    public void testCheckExistenceUser()
    {
        //Отправляем запрос
        Response resp = get(PATH_USERS +"/Stewie-1989");

        // Cравниваем статус код
        Assert.assertEquals(resp.getStatusCode(),200);

        // Cохраняем данные в объект типа User
        User user = resp.as(User.class);

        // Сравниваем айди пользователя с известным
        Assert.assertEquals(user.getId(),"32819590");
    }

    /**
     * Создания репозитория
     */
    @Test
    @Description("Сreating a repository")
    public void testCreateRepository()
    {
        // Если репозиторий существует удалить его
        if(get(PATH_REPOSITORY_STEWIE + NAME_REPOSITORY ).statusCode() == 200)
        {
            given().auth()
                    .oauth2(TOKEN)
                    .when()
                    .delete(PATH_REPOSITORY_STEWIE + NAME_REPOSITORY);
        }


        // Создать репозиторий
        Response response = given().auth()
                .oauth2(TOKEN)
                .body(DATA)
                .when()
                .post(PATH_REPOSITORY_USER);

        // Проверить что репозиторий бьыл создан
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    /**
     * Удаления репозитория
     */

    @Test
    @Description("Deleting a repository")
    public void testDeleteRepository()
    {
        if(get(PATH_REPOSITORY_STEWIE + NAME_REPOSITORY).statusCode() == 404)
        {
            given().auth()
                    .oauth2(TOKEN)
                    .body(DATA)
                    .when()
                    .post(PATH_REPOSITORY_USER);
        }

        Response response = given().auth()
                .oauth2(TOKEN)
                .when()
                .delete(PATH_REPOSITORY_STEWIE + NAME_REPOSITORY);

        Assert.assertEquals(response.getStatusCode(), 204);
    }

    /**
     * Подтверждения наличия репозиториев у одного и того же объекта
     */

    @Test
    @Description("Availability of repositories for the same user")
    public void testCheckRepository()
    {
        // Получение данных о репозиториях
        Response responseRepository = get(PATH_USERS +  "/Stewie-1989/repos");

        // Получение данных о пользователе
        Response responseUser = get(PATH_USERS + "/Stewie-1989");

        // Получение массива данных репозиториев юзера
        Repository[] repositories = responseRepository.as(Repository[].class);

        // Преобразования данных пользователя в клас юзер
        User user = responseUser.as(User.class);

        // Проверка пренадлежности репозиторием юзеру
        for(Repository repository : repositories)
           Assert.assertEquals(repository.getOwner().getId(), user.getId());

    }

    /**
     * Наличие последователей у юзера
     */


    @Test
    @Description("Presence of the next the user")
    public void testCheckFollowingFollowers()
    {
        // Флажок определения наличия следующего у юзера
        boolean following = false;

        // Флажок определения наличия последователей у юзера
        boolean follower = false;

        // Массив данных последователей
        Follow[] followingsStewie = get(PATH_USERS + "/Stewie-1989/following").as(Follow[].class);

        // Массив данных следующих
        Follow[] followersRomankovsv = get(PATH_USERS + "/romankovsv/followers").as(Follow[].class);

        // Проверка наличия последователей уюзера
        for(Follow followings : followingsStewie)
        {
            if(followings.getLogin().equals("romankovsv"))
            {
                following = true;
                break;
            }
        }
        Assert.assertTrue(following);

        // Проверка наличия следующих уюзера
        for(Follow followers : followersRomankovsv)
        {
            if(followers.getLogin().equals("Stewie-1989"))
            {
                follower = true;
                break;
            }
        }
        Assert.assertTrue(follower);
    }

    /**
     * Проверка изменения событий
     */
    @Test
    @Description("Checking events changes and add events")
    public void testEventAdd()
    {


        // Возвращает массив из 30 последних событий до создания и удаления
        Event[] event1 = get(PATH_USERS + "/Stewie-1989/events")
                .as(Event[].class);

        // События создания и удаления репозитория
        if(get(PATH_REPOSITORY_STEWIE + NAME_REPOSITORY ).statusCode() == 200)
        {
            given().auth()
                    .oauth2(TOKEN)
                    .when()
                    .delete(PATH_REPOSITORY_STEWIE + NAME_REPOSITORY);
        }

        given().auth()
                .oauth2(TOKEN)
                .body(DATA)
                .when()
                .post(PATH_REPOSITORY_USER);

        given().auth()
                .oauth2(TOKEN)
                .when()
                .delete(PATH_REPOSITORY_STEWIE + NAME_REPOSITORY);

        // Возвращает массив из 30 последних событий после создания и удаления
        Event[] event2 = get(PATH_USERS + "/Stewie-1989/events")
                .as(Event[].class);

        // Преобразование в списоки массивов событий
        List<Event> list1 = Arrays.asList(event1);
        List<Event> list2 = Arrays.asList(event2);

        // Счетчик одинаковых значений
        final int[] counter = {0};

        // Вычеркивание одинаковых значений
        list1.forEach(list_1 -> {
            list2.forEach(list_2 ->{
                if(Long.parseLong(list_1.getId()) == Long.parseLong(list_2.getId()))
                {
                    list_1.setId("0");
                    list_2.setId("0");
                    counter[0]++;
                }
            });
        });

        // Количество не одинаковых событий
        final int NUMBER = list1.size() - counter[0];

        // Счетчики событий не имеющих 0 Id
        int counter_list1 = 0;
        int counter_list2 = 0;

        // Проверка количества не нулевых элементов и порядок их следования в списках
        for(int i = 0; i < list1.size(); i++)
        {
            if(!list2.get(i).getId().equals("0"))
            {
                Assert.assertTrue(i < NUMBER);
                counter_list1++;
            }

            if(!list1.get(i).getId().equals("0"))
            {
                Assert.assertTrue(i >= counter[0]);
                counter_list2++;
            }

            Assert.assertTrue(counter_list1 <= NUMBER && counter_list2 <= NUMBER);
        }

    }



}

