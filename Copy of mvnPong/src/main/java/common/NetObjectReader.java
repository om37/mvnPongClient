package common;

import java.io.*;
import java.net.Socket;

/**
 * Wrapper to allow reading of objects from a socket
 */
public class NetObjectReader extends ObjectInputStream
{
  public NetObjectReader( Socket s ) throws IOException
  {
      super( s.getInputStream() );
      DEBUG.trace("NetObjectReader constructor");
  }

  // Get object return null on 'error'
  public synchronized Object get()           // Get object from stream
  {
    try                                      //
    {
      DEBUG.trace("NetObjectReader get");
      return readObject();                   // Return read object
    }
    catch ( Exception err )                  // Reading error
    {
      DEBUG.trace("NetObjectReader.get %s", 
                   err.getMessage() );
      return null;                           //  On error return null
    }
  }
}


