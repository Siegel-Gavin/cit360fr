
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

//This is the controller, it handles the logic.

public class listControl {
    private Scanner in = new Scanner(System.in);
    private LinkedList<State> states = new LinkedList<>();

    public listControl() {
    }

        public void addNewState(){
            StateView sv = new StateView();
            sv.addNewStateView();
            System.out.println("State Name:");
            String stateName = in.next();
            System.out.println("State Capitol:");
            String stateCapitol = in.next();
            State state = new State();
            state.setStateName(stateName);
            state.setStateCapitol(stateCapitol);
            state.add(state);
        }

        public void deleteState() {
            states.remove();
            StateView sv = new StateView();
            sv.deleteStateView(states);
        }

        public void listStates() {
            StateView sv =  new StateView();
            for (State state:
                states) {
                sv.listStatesView(state);
                }
        }

    public void menu() {
        StateView sv = new StateView();
        sv.stateMenu();

        boolean quit = false;

        int menuItem;

        do {

            System.out.print("Choose an option: ");
            menuItem = in.nextInt();
            switch (menuItem) {
                case 1:
                    addNewState();
                    break;
                case 2:
                    deleteState();
                    break;
                case 3:
                    listStates();
                    break;
                case 0:
                    quit = true;
                    pv.exitMessage();
                    break;
                default:
                    pv.invalidMessage();
            }
        } while (!quit);
    }
}