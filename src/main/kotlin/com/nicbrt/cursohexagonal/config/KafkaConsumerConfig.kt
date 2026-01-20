package com.nicbrt.cursohexagonal.config

import com.nicbrt.cursohexagonal.adapters.`in`.consumer.message.CustomerMessage
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig {

    private val configProps = mapOf( // Cria um mapa imutável com propriedades básicas do consumidor
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092", // Endereço do broker Kafka usado para conectar
        ConsumerConfig.GROUP_ID_CONFIG to "nicbrt", // ID do grupo de consumidores para coordenar offsets
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to JsonDeserializer::class.java,
        ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest" // Política para offsets quando não há offset inicial: começar do início
    )

    // Bean que cria a fábrica de consumidores usada pelos listener containers.
    // Retorna um ConsumerFactory<String, CustomerMessage> que sabe criar consumers
    @Bean
    fun consumerFactory(): ConsumerFactory<String, CustomerMessage> =
        DefaultKafkaConsumerFactory(configProps, StringDeserializer(), JsonDeserializer(CustomerMessage::class.java))

    // Bean que fornece a fábrica de containers para os métodos anotados com @KafkaListener.
    // O container factory cria os containers que executam os listeners e delegam a leitura das mensagens ao ConsumerFactory definido acima.
    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> =
        ConcurrentKafkaListenerContainerFactory<String, CustomerMessage>().apply {
            consumerFactory = consumerFactory()
        }

}