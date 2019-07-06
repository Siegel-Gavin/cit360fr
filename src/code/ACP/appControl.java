pimport java.util.HashMap;

public class appControl {
    //This will map a command with all of the controllers implementing the handler interface
    private HashMap<String,Handler> handlerMap = new HashMap();

    public void handleRequest(String command, State state){
        //Map a command to the controller
        handlerMap.put("list", new list());

        //Get the needed controller
        Handler handler = handlerMap.get(command);
        //Execute the controller through the interface
        handler.handleIt(state);
    }

}