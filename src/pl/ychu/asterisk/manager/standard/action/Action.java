package pl.ychu.asterisk.manager.standard.action;

import java.util.ArrayList;
import java.util.List;

public class Action extends AbstractAction {

    private String actionName;
    private List<Variable> variableList;

    public Action(String actionName) {
        this.actionName = actionName;
        variableList = new ArrayList<>();
    }

    public void putVariable(String name, String value) {
        variableList.add(new Variable(name, value));
    }

    public void removeVariable(String name) {
        for (Variable variable : variableList) {
            if (!variable.getName().equals(name)) {
                continue;
            }
            variableList.remove(variable);
        }
    }

    @Override
    protected String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Action: ").append(this.actionName).append("\n");
        for (Variable variable : variableList) {
            sb.append(variable.getName()).append(": ").append(variable.getValue()).append("\n");
        }
        return sb.toString();
    }

    private class Variable {
        private String name;
        private String value;

        public Variable(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
