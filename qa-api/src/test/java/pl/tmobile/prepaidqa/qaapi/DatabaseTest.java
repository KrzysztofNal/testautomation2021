package pl.tmobile.prepaidqa.qaapi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pl.tmobile.prepaidqa.qadatabase.dao.UserDao;
import pl.tmobile.prepaidqa.qadatabase.model.UserDb;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@Tags({@Tag("database"), @Tag("Api")})
@DisplayName("Database tests")
public class DatabaseTest {

    @Test
    public void databaseGetUsersTest() {
        List<UserDb> users = UserDao.getAllUserDb();
        assertThat(users.get(0).id).isEqualTo("1");
        assertThat(users.get(0).name).isEqualTo("Piotr");
        assertThat(users.get(0).surname).isEqualTo("Kowalski");
    }

    @Test
    public void databaseGetUserByIdTest() {
        UserDb user = UserDao.getUserDbById("1");
        assertThat(user.id).isEqualTo("1");
        assertThat(user.name).isEqualTo("Piotr");
        assertThat(user.surname).isEqualTo("Kowalski");
    }

    @Test
    public void addUser() {
        UserDao.saveUser(new UserDb("4", "Karol", "Lipa"));

        UserDb userDb = UserDao.getUserDbById("4");

        assertThat(userDb.id).isEqualTo("4");
        assertThat(userDb.name).isEqualTo("Karol");
        assertThat(userDb.surname).isEqualTo("Lipa");

        UserDao.deleteUser("4");
        UserDb userDeleted = UserDao.getUserDbById("4");
        assertThat(userDeleted).isNull();
        System.out.println(userDeleted);

    }
}
