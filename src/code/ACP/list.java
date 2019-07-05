import sun.jvm.hotspot.memory.Generation;

import javax.persistence.*;

public class list {

    private Integer id;

    private String stateName;
    private String stateCapitol;

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }

        public String getStateCapitol() {
            return stateCapitol;
        }

        public void setStateCapitol(String stateCapitol) {
            this.stateCapitol = stateCapitol;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
}