package binarytreesize;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {

    Node node;
    ExecutorService executorService;
    TreeSizeCalculator(Node node, ExecutorService executorService){
        this.node=node;
        this.executorService=executorService;
    }


    @Override
    public Integer call() throws Exception {
        if(node==null){
            return 0;
        }
        TreeSizeCalculator left=new TreeSizeCalculator(node.left,executorService);
        TreeSizeCalculator right=new TreeSizeCalculator(node.right,executorService);

        Future<Integer> leftFuture=executorService.submit(left);
        Future<Integer> rightFuture=executorService.submit(right);

        return leftFuture.get()+rightFuture.get()+1;
    }
}
