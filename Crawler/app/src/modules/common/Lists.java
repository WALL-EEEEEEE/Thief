/**
 * Description: List集合操作工具类
 *
 *
 */
public class Lists{


    /**
     * Description: appendable<List>中的元素都加到src<List>元素的末尾
     * @param List<T> src 该List中的元素将被附加
     * @param List<T> appendable 该List中的元素用于附加
     *
     */
    public <T> static List<T> appendAll(List<T> src,List<T> appendable  ){
        List<T> dlist = new ArrayList<T>();
        T s  = null;
        T ss = null;
        String ds = "";

        for(s:src){

            for(ss:appendable){

                ds = String.append(s.toString(),ss.toString());
                dlist.add(ds);


            }

        }

        return dlist;



    }







}
