package com.project.quotableapi.quotableapi;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/", 
				glue = { "com.project.quotableapi.quotableapi" }, 
                 monochrome=true, plugin = {"pretty"},
                 tags = "@quotableAPI")

public class CucumberRunner {

}
