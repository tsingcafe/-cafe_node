/**
 * Created by eric on 9/24/16.
 */

package cn.edu.tsinghua.cess.datamanager.nclscript;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ericxuhao
 */
public class RegionEOF implements NclScript{

    @Override
    public void run(NclScriptContext context) {
        String lat_min=String.valueOf(context.getLatMin());
        String lat_max=String.valueOf(context.getLatMax());
        String lon_min=String.valueOf(context.getLonMin());
        String lon_max=String.valueOf(context.getLonMax());
        CmdExecutor cExecutor=new CmdExecutor(context);
        File file_ori=cExecutor.getEOFOriData(context,30);
        File file_cdo=cExecutor.getCdoData(context, file_ori,50);
        //File file_year=cExecutor.getYearData(context, file_cdo,60);
        OutputFile[] outputFiles=new OutputFile[3];
        String Alia="_"+lat_min+"-"+lat_max+"_"+lon_min+"-"+lon_max;
        outputFiles[0]=new OutputFile(NclScriptContext.RESULT_TYPE_NC,new String[]{"EOF"+Alia},new String[]{"nc_name"},1);
        outputFiles[1]=new OutputFile(NclScriptContext.RESULT_TYPE_TXT,new String[]{"EOF-TS"+Alia},new String[]{"txt_name"},1);
        outputFiles[2]=new OutputFile(NclScriptContext.RESULT_TYPE_FIG,new String[]{"EOF"+Alia},new String[]{"fig_name"},6);
        cExecutor.runNcl(context, file_cdo, outputFiles, CmdExecutor.FIGURE_TYPE_ADDLON,"RegionEOF.ncl", null);
        cExecutor.rmData(context,file_ori);
        cExecutor.rmData(context,file_cdo);


    }

}
