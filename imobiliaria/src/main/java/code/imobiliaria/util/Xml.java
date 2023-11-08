/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.imobiliaria.util;

import code.imobiliaria.modelo.Cliente;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;

public class Xml {

    public static void exportToXml(Object data, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(data.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(data, (Result) file);
    }

    public static <T> T importFromXml(Class<T> type, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(type);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return type.cast(unmarshaller.unmarshal(file));
    }
    
// Exporting a list of clients to XML
List<Cliente> clients = // ... get your list of clients
File file = new File("clients.xml");
try
    private List<Cliente> File;
{
    Xml.exportToXml(clients, file);
    System.out.println("Exported clients to XML");
} catch (JAXBException e) {
    e.printStackTrace();
}

// Importing a list of clients from XML
File file = new File("clients.xml");
try {
        try {
            List<Cliente> importedClients = Xml.importFromXml(List.class, file);
        } catch (JAXBException ex) {
            Logger.getLogger(Xml.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println("Imported clients from XML");
} catch (JAXBException e) {
    e.printStackTrace();
}
}