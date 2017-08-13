import org.gradle.tooling.BuildLauncher
import org.gradle.tooling.GradleConnector
import org.gradle.tooling.ProjectConnection
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

/**
 * @author yangxiaochen
 * @date 2017/8/9 00:51
 */
class GradleTest {

    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder()
    private File buildFile

    @Test
    void createTasks() {
        buildFile = testProjectDir.newFile("build.gradle")
        buildFile << this.class.getResourceAsStream("/build.gradle")
        ProjectConnection connection = GradleConnector.newConnector()
                .forProjectDirectory(testProjectDir.getRoot())
                .connect()

        try {
            BuildLauncher launcher = connection.newBuild().forTasks("tasks")
            launcher.run()


        } finally {
            connection.close()
        }
    }
}
