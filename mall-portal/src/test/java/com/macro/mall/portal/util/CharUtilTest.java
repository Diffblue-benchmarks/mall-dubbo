package com.zscat.mall.portal.util;

import static org.mockito.Matchers.anyInt;

import com.zscat.mall.portal.util.CharUtil;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class CharUtilTest {

  @PrepareForTest({CharUtil.class})
  @Test
  public void testGetRandomNum() throws Exception {
    final Random random = PowerMockito.mock(Random.class);
    PowerMockito.when(random.nextInt(anyInt())).thenReturn(8);
    PowerMockito.whenNew(Random.class).withNoArguments().thenReturn(random);

    Assert.assertEquals("8", CharUtil.getRandomNum(1));
    Assert.assertEquals("", CharUtil.getRandomNum(0));
  }

  @PrepareForTest({CharUtil.class})
  @Test
  public void testGetRandomString() throws Exception {
    final Random random = PowerMockito.mock(Random.class);
    PowerMockito.when(random.nextInt(anyInt())).thenReturn(32);
    PowerMockito.whenNew(Random.class).withNoArguments().thenReturn(random);

    Assert.assertEquals("6", CharUtil.getRandomString(1));
    Assert.assertEquals("", CharUtil.getRandomString(0));
  }

  @Test
  public void testPadLeft() {
    Assert.assertEquals("a\'b\'c\u0000",
            CharUtil.padLeft("a\'b\'c", 6, '\u0000'));
    Assert.assertEquals("1", CharUtil.padLeft("1", 0, '\u0000'));
  }

  @Test
  public void testPadRight() {
    Assert.assertEquals("\u0000a\'b\'c",
            CharUtil.padRight("a\'b\'c", 6, '\u0000'));
    Assert.assertEquals("1", CharUtil.padRight("1", 0, '\u0000'));
  }
}
