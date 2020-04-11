package org.neuroph.training;

import java.util.List;
import org.neuroph.core.data.DataSet;
import org.neuroph.util.NeurophProperties;
import org.neuroph.util.data.sample.Sampling;
import org.neuroph.util.data.sample.SubSampling;

/**
 * Executes sampling task for the data set in process.
 * @author Zoran Sevarac
 */
public class SamplingTask extends Task {
    DataSet dataSet;
    Sampling sampling;
    DataSet[] dataSetSample;

    public SamplingTask(String name) {
        super(name);
    }

//    public SamplingTask(Sampling sampling) {
//        super("SamplingTask");
//        this.sampling = sampling;
//    }

     // how to choose sampling method
    @Override
    public void execute() {
        NeurophProperties trainingProperties = (NeurophProperties)getVariable("trainingProperties");
        NeurophProperties crossValProps = (NeurophProperties)trainingProperties.get("crossValidationProperties");

        dataSet = (DataSet)getVariable("dataSet");
        int trainingSetPercent =  (Integer)crossValProps.get("trainingSetPercent") ;

        logMessage("Sampling data set to create training and test sets: "+trainingSetPercent+" % / "+(100-trainingSetPercent) +"%");

        this.sampling = new SubSampling(trainingSetPercent);
        dataSetSample = dataSet.sample(sampling);

        parentProcess.setVariable(new Variable<>("trainingSet", dataSetSample[0]));
        parentProcess.setVariable(new Variable<>("testSet", dataSetSample[1]));
    }


}