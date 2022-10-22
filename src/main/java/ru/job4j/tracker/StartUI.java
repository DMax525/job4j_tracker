package ru.job4j.tracker;

import ru.job4j.ex.User;

import java.util.List;
import java.util.*;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actionsArray = {
                new CreateAction(output), new ShowAction(output), new EditAction(output),
                new DeleteAction(output), new FindByIdAction(output), new FindByNameAction(output),
                new ExitAction(output)
        };
        List<UserAction> actions = Arrays.asList(actionsArray);
        new StartUI(output).init(input, tracker, actions);
    }
}
