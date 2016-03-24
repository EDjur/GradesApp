package mansci.gradesapp.manSciModules;

/**
 * Interface to help generalise the calculations of module grades into one single class.
 * Tells all classes that implement this interface that they must contain the following methods.
 */
public interface Module {
    int getAssignmentId(int index);

    int getWeightId(int index);

    int getGradeId(int index);
}
