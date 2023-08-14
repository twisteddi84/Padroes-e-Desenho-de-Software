package ex03;

import java.util.Collection;

public class RemoveCommand<E> implements Command{
        private final Collection<E> colecao;
        private final E elemento;
    
        public RemoveCommand(Collection<E> collection, E element) {
            colecao = collection;
            elemento = element;
        }
    
        public void execute() {
            colecao.remove(elemento);
        }
    
        public void undo() {
            colecao.add(elemento);
        }
    }

