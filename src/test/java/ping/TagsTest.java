package ping;

import api.TagsApi;
import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;

public class TagsTest extends BaseTest {

    @BeforeMethod
    public void creatingArticleSetUp() {
        commonFlows.createArticle();
    }

    @Test
    public void getTags() {
        final var getTag = new TagsApi(true);

        final var responseGetTag = getTag.getAllTags().then().assertThat()
                .statusCode(200)
                .time(lessThan(3000L));
    }
}
