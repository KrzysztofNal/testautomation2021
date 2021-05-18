package pl.tmobile.prepaidqa.qaapi;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.tmobile.prepaidqa.qaapi.azure.model.activities.Activities;
import pl.tmobile.prepaidqa.qaapi.azure.service.activities.ActivitiesService;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import static com.google.common.truth.Truth.assertThat;

@Tags({@Tag("Azure"), @Tag("sanity"), @Tag("Activities")})
@DisplayName("Azure Activities test")
public class AzureActivitiesTest {

    Logger logger = Logger.getLogger("ApiTest");

    @BeforeEach
    public void beforeEach() {
        logger.info("==========================");
        RestAssured.filters(new RequestLoggingFilter());
        logger.info("==========================");
    }

    @AfterEach
    public void afterEach() {
        logger.info("==========================");
        RestAssured.filters(new ResponseLoggingFilter());
        logger.info("==========================");

    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    public void azureActivitiesTest(int id) {

        final Activities activities = ActivitiesService.getActivitiesById(id);

        assertThat(activities.getId()).isEqualTo(id);
        assertThat(activities.getTitle()).isEqualTo("Activity " + id);

        final LocalDateTime localDateTime = LocalDateTime.now().atZone(ZoneId.of("UTC")).toLocalDateTime().minusHours(2);

        assertThat(activities.getDueDate()).contains(localDateTime.plusHours(id).toLocalDate().toString());
        assertThat(activities.getDueDate()).contains(localDateTime.plusHours(id).toLocalTime().format(DateTimeFormatter.ofPattern("HH")));
        assertThat(activities.isCompleted()).isEqualTo(id % 2 == 0);
    }
}
