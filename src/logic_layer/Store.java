package logic_layer;

import exceptions.CopyNotFoundException;

public class Store {

	public void returnCopy(String copyId) throws CopyNotFoundException {
		Copy returnedCopy = new Copy().getCopybyId(copyId);
		returnedCopy.goInStock();
	}

	public void removeCopy(String copyId) throws CopyNotFoundException {
		Copy removedCopy = new Copy().getCopybyId(copyId);
		removedCopy.goOutStock();
	}

}
