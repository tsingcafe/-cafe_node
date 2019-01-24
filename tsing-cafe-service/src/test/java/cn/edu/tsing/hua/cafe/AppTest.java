package cn.edu.tsing.hua.cafe;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import cn.edu.tsing.hua.cafe.impl.DeploymentJustImpl;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Resource
    DeploymentJustImpl deploymentService;
    @Test
    public void shouldAnswerWithTrue()
    {
        deploymentService.test();
        assertTrue( true );
    }
}
