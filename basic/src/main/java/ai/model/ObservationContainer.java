package ai.model;

import edu.emory.mathcs.backport.java.util.Collections;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.List;
import java.util.stream.Stream;

@Immutable
public class ObservationContainer<OBSERVATION_TYPE> {
    private final List<OBSERVATION_TYPE> observations;

    private ObservationContainer(List<OBSERVATION_TYPE> observations) {
        this.observations = observations;
    }

    public static <OBSERVATION_TYPE> ObservationContainer<OBSERVATION_TYPE> newContainer(List<OBSERVATION_TYPE> points) {
        return new ObservationContainer<>(points);
    }

    public double size() {
        return observations.size();
    }

    public Stream<OBSERVATION_TYPE> streamObservation() {
        return observations.stream();
    }

    public List<OBSERVATION_TYPE> listObservation() {
        return Collections.unmodifiableList(observations);
    }
}
