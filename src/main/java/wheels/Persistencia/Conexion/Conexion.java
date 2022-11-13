package wheels.Persistencia.Conexion;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;


import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class Conexion {

    private static Conexion singleton;
    protected MongoClient mongoClient;
    protected MongoDatabase db;
    protected CodecRegistry defaultCodecRegistry;

    private Conexion()
    {
            mongoClient = MongoClients.create("mongodb+srv://WheelsPF:WheelsPF@wheelsproyectofundament.mlzmz9a.mongodb.net/?retryWrites=true&w=majority");
            db = mongoClient.getDatabase("WheelsBD");
            defaultCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    }

    public static Conexion obtenerConexion()
    {
        if (singleton==null)
        {
            singleton = new Conexion();
        }
        return singleton;
    }

    public void cerrarConexion()
    {
        this.singleton = null;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getDb() {
        return db;
    }

    public CodecRegistry getDefaultCodecRegistry() {
        return defaultCodecRegistry;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public void setDb(MongoDatabase db) {
        this.db = db;
    }

    public void setDefaultCodecRegistry(CodecRegistry defaultCodecRegistry) {
        this.defaultCodecRegistry = defaultCodecRegistry;
    }
}
