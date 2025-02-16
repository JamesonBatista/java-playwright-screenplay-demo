package pages;

import interactions.Click;
import interactions.Fill;
import interactions.Select;
import interactions.Text;
import screen.Actor;
import screen.Question;
import screen.Task;

import static utils.ConfigManager.getProperty;


public class Register implements Task {

    public static Register FillForm() {
        return new Register();
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
                Fill.field("input[id=\"name\"]", getProperty("name")),
                Fill.field("[id=\"email\"]", getProperty("email")),
                Fill.field("[id=\"password\"]", getProperty("password").toString()),
                Fill.field("[id=\"birthdate\"]", getProperty("dat_nasc")),
                Fill.field("#phone", getProperty("phone").toString()),
                Fill.field("#address", getProperty("address")),
                Select.from("#state", "São Paulo"),
                Select.from("#city", "São Paulo"),
                Click.on("#terms"),
                Click.on("[type=\"submit\"]"),
                Text.contain("#alertMessage", "Cadastro realizado com sucesso!")


        );


    }
}
