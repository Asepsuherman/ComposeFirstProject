package id.utdi.asepsuherman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
//import id.utdi.asepsuherman.ui.theme.ComposeFirstProjectTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Oncreate untuk mengatur tampilan konten dengan menggunakan `seatcontent` yang memanggil `MessageCard`
        super.onCreate(savedInstanceState)
        setContent {
            //Untuk menampilkan  card pesan
            MessageCard(Message("AsepSuher", "Baru bisa segini aja pak hehe:)"))
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    // Row untuk mengatur elemen menjadi satu dalam satu baris
    Row(modifier = Modifier.padding(all = 8.dp)) {
        //Image komponen yang menampilkan gambar
        Image(
            //ic_launcher_background adalah nama file yg dipanggil
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Mengatur ukuran image menjadi 40 dp
                .size(40.dp)
                // Membuat image menjadi circular atau bulat
                .clip(CircleShape)
        )

        //Untuk menambah ruang horizontal antara gambar dan kolom
        Spacer(modifier = Modifier.width(8.dp))

        //Column untuk mengatur elemen  dalam satu kolom menjadi vertikal
        Column {
            Text(text = msg.author)
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }
}

@Preview
@Composable
//PriiviewMessageCard adalah fungsi kompos untuk menampilkan tampilan MessageCard
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
    )
}
