package br.com.itads.miniauth.commons.test;

import br.com.itads.miniauth.commons.util.MiniAuthUtils;
import junit.framework.TestCase;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 */
public class MiniAuthUtilsTest extends TestCase {

  /**
   * 
   */
  public void testReturnEmpty() {
    assertEquals("", MiniAuthUtils.returnEmpty());
  }
  
}
