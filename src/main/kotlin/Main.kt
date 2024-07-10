import glide.api.GlideClient
import glide.api.models.configuration.GlideClientConfiguration
import glide.api.models.configuration.NodeAddress
import kotlinx.coroutines.future.await
import org.testcontainers.containers.GenericContainer
import org.testcontainers.utility.DockerImageName

val container = GenericContainer(DockerImageName.parse("valkey/valkey")).withExposedPorts(6379)

suspend fun main() {
    container.start()

    val address = NodeAddress.builder().host(container.host).port(container.firstMappedPort).build()
    val config = GlideClientConfiguration.builder().address(address).build()

    val client = GlideClient.createClient(config).await()

    println("PING: " + client.ping().await())
    println("PING(found you): " + client.ping("found you").await())

    println("SET(apples, oranges): " + client.set("apples", "oranges").await())
    println("GET(apples): " + client.get("apples").await())
}
