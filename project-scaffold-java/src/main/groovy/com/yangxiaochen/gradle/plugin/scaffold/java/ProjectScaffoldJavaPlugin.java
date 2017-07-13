package com.yangxiaochen.gradle.plugin.scaffold.java;

import org.gradle.api.DefaultTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

/**
 * @author yangxiaochen
 * @date 2017/7/13 21:55
 */
public class ProjectScaffoldJavaPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getTasks().create("createSrc", SourceSetCreateTask.class);
    }
}

class SourceSetCreateTask extends DefaultTask {

    public static final String mainJava = "src/main/java";
    public static final String mainResource = "src/main/resources";
    public static final String testJava = "src/test/java";
    public static final String testResource = "src/test/resources";

    @TaskAction
    public void greet() {
        getProject().mkdir(mainJava);
        getProject().mkdir(mainResource);
        getProject().mkdir(testJava);
        getProject().mkdir(testResource);
    }
}
