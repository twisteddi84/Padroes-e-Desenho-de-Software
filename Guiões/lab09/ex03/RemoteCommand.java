package ex03;

import java.util.Stack;

public class RemoteCommand {
        private final Stack<Command> stack = new Stack<>();
    
        public void executeCommand(Command command) {
            command.execute();
            stack.push(command);
        }
    
        public void undo() {
            Command comando;
            boolean bol = stack.isEmpty();
            if (!bol) {
                comando = stack.pop();
                comando.undo();
            }
        }
    }
    
