package ex03;

import java.util.Collection;

public class AddCommand<E> implements Command {
        private final Collection<E> colecao;
        private final E elemento;
    
        public AddCommand(Collection<E> collection, E element) {
            colecao = collection;
            elemento = element;
        }
    
        public void execute() {
            colecao.add(elemento);
        }
    
        public void undo() {
            colecao.remove(elemento);
        }
    }

