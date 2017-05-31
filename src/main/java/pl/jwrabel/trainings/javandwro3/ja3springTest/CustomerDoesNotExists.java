package pl.jwrabel.trainings.javandwro3.ja3springTest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jakubwrabel on 31/05/2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerDoesNotExists extends Exception {
}
