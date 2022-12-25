import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.intNumbersFlux().subscribe(
//            num -> System.out.println(num),
//            err -> System.out.println(err.getMessage()),
//            () -> System.out.println("Completed")
//        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new mySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }
}

class mySubscriber<T> extends BaseSubscriber<T>{
    public void hookOnSubscribe(Subscription subscription){
        System.out.println("Subscribed");
        request(1);
    }

    public void hookOnNext(T value){
        System.out.println(value.toString() + " received");
        request(1);
    }
}
