package by.it.kushel.jd01_08;

/**
 * Created by Diomn on 21.05.2016.
 */
public class Calculator implements IOperations {
    @Override
    public IVariable add(IVariable var1, IVariable var2) {

        if((var1 instanceof DoubleVariable)&&(var2 instanceof DoubleVariable)){

            DoubleOperations res = new DoubleOperations();
            System.out.println(res.add(var1, var2));

        }
        if((var1 instanceof VectorVariable)&&(var2 instanceof VectorVariable)){

            VectorOperations res = new VectorOperations();
            System.out.println(res.add(var1, var2));
        }else
        System.out.println("Операция с данными типами переменных невозможна");
        return null;
    }
    private class DoubleOperations implements IOperations{
        @Override
        public  IVariable add(IVariable var1, IVariable var2) {

            DoubleVariable res  = new DoubleVariable();
            double resValue=(double)(var1.getValue())+ (double)(var2.getValue());
            res.setValue(resValue);
            return res;
        }
    }
    private class VectorOperations implements IOperations {
        @Override
        public IVariable add(IVariable var1, IVariable var2) {


            VectorVariable res=new VectorVariable();

            Double[] arg1 = (Double[])((DoubleVariable)var1).getValue();
            Double[] arg2 =(Double[])((DoubleVariable)var2).getValue();
            Double[] resVector=new Double[arg1.length];

            if (arg1.length==arg2.length){
                for (int i=0; i<arg1.length; i++){
                    for (int j=0; j<arg2.length; j++){
                        resVector[i]= arg1[i]+arg2[j];
                    }
                }
            }
            res.setValue(resVector);
            return res;

        }
    }
}
