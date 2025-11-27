package api_tests;

import dto.Contact;
import dto.TokenDto;
import dto.User;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseApi;
import utils.ContactFactory;

import java.io.IOException;

// I am

public class UpdateContact implements BaseApi {

    TokenDto token;

    @BeforeClass
    public void login() {
        User user = new User("iv@mail.com", "123456Aa!");
        RequestBody requestBody = RequestBody.create(GSON.toJson(user), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + LOGIN)
                .post(requestBody)
                .build();
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (response.code() == 200) {
            try {
                token = GSON.fromJson(response.body().string(), TokenDto.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Test
    public void updateContactPositiveTest() throws IOException {
        Contact contact = ContactFactory.positiveContact();
        RequestBody requestBody = RequestBody.create(GSON.toJson(contact), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + ADD_NEW_CONTACT)
                .addHeader(AUTH, token.getToken())
                .post(requestBody)
                .build();
        Response response;
        String createdId;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            String bodyResponse = response.body().string();
            System.out.println(response.body());
            createdId = bodyResponse.replace("Contact was added! ID: ", "").trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (response.code() == 200) {
            Contact updateContact = ContactFactory.positiveContact();
            updateContact.setId(createdId);
            updateContact.setLastName("UpdateLastName");

            RequestBody updateBody = RequestBody.create(GSON.toJson(updateContact), JSON);
            Request updateRequest = new Request.Builder()
                    .url(BASE_URL + UPDATE_CONTACT)
                    .addHeader(AUTH, token.getToken())
                    .put(updateBody)
                    .build();
            try {
                response = OK_HTTP_CLIENT.newCall(updateRequest).execute();
                System.out.println(response.body().string());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(response.code());
            Assert.assertEquals(response.code(), 200);
        }
    }


}