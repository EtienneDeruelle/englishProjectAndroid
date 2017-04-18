package buisiness;

import java.io.StringBufferInputStream;

/**
 * Created by etienne on 17/04/17.
 */

public class Rule {

    private int idRule;
    private String tagName;
    private String rule;
    private String ruleTranslation;

    public Rule(int idRule, String tagName, String rule, String ruleTranslation) {
        this.idRule = idRule;
        this.tagName = tagName;
        this.rule = rule;
        this.ruleTranslation = ruleTranslation;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getIdRule() {
        return idRule;
    }

    public void setIdRule(int idRule) {
        this.idRule = idRule;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getRuleTranslation() {
        return ruleTranslation;
    }

    public void setRuleTranslation(String ruleTranslation) {
        this.ruleTranslation = ruleTranslation;
    }
}
