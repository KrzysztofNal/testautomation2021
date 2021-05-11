package pl.tmobile.prepaidqa.qaapi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.tmobile.prepaidqa.qaapi.azure.model.activities.Activities;
import pl.tmobile.prepaidqa.qaapi.azure.service.activities.ActivitiesService;

import java.time.LocalDateTime;

import static com.google.common.truth.Truth.assertThat;

@Tags({@Tag("Azure"), @Tag("sanity"), @Tag("Activities")})
@DisplayName("Azure Activities test")
public class AzureActivitiesTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    public void azureActivitiesTest(int id) {

        final Activities activities = ActivitiesService.getActivitiesById(id);

        assertThat(activities.getId()).isEqualTo(id);
        assertThat(activities.getTitle()).isEqualTo("Activity " + id);
        assertThat(activities.getDueDate()).contains("2021-05-11");
        assertThat(activities.isCompleted()).isEqualTo(id % 2 == 0 ? true : false);
    }
}
