package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkillsController {

    @GetMapping("")
    @ResponseBody
    public String renderIndex() {
        return """
            <h1>Skills Tracker</h1>
            <h2>We have a few skills we would like to learn. Here is the list!</h2>
            <ol>
                <li>Java</li>
                <li>JavaScript</li>
                <li>Python</li>
            </ol>
            """;
    }

    @GetMapping("form")
    @ResponseBody
    public String renderFormPage() {
        String languageTemplate = """
            <label>My %s favorite language:</label>
            <select name="%s">
                <option>Java</option>
                <option>JavaScript</option>
                <option>Python</option>
            </select>
            """;

        return """
            <form method="post">
                Name:
                <input name="name"/><br/>
                %s<br/>
                %s<br/>
                %s<br/>
                <input type="submit" />
            </form>
            """.formatted(
                languageTemplate.formatted("", "first"),
                languageTemplate.formatted("second", "second"),
                languageTemplate.formatted("third", "third"));
    }

    @PostMapping("form")
    @ResponseBody
    public String renderUserPreferences(String name, String first, String second, String third) {
        return """
            <h1>%s</h1>
            <ol>
                <li>%s</li>
                <li>%s</li>
                <li>%s</li>
            </ol>
    """.formatted(name, first, second, third);
    }
}
