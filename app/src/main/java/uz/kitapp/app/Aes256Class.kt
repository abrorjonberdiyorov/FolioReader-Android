package uz.kitapp.app

import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey


class Aes256Class {
    private var secretKey: SecretKey? = null

    fun encryptdecrypt(rawMessage: ByteArray?, cipherMode: Int): ByteArray? {
        return try {
            val cipher: Cipher = Cipher.getInstance("AES")
            cipher.init(cipherMode, secretKey)
            cipher.doFinal(rawMessage)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    init {
        try {
            val keyGenerator: KeyGenerator = KeyGenerator.getInstance("AES")
            keyGenerator.init(256)
            secretKey = keyGenerator.generateKey()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
    }
}