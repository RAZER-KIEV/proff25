package hw8.taxi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
    @Value("${countAttemptsToEnterPassword}")
    private Integer countAttempts;

    @Value("${timeOfActionPassword}")
    private Integer timeOfAction;

    public Properties() {
    }

    public Properties(Integer countAttempts, Integer timeOfAction) {
        this.countAttempts = countAttempts;
        this.timeOfAction = timeOfAction;
    }

    public Integer getCountAttempts() {
        return countAttempts;
    }

    public void setCountAttempts(Integer countAttempts) {
        this.countAttempts = countAttempts;
    }

    public Integer getTimeOfAction() {
        return timeOfAction;
    }

    public void setTimeOfAction(Integer timeOfAction) {
        this.timeOfAction = timeOfAction;
    }
}
