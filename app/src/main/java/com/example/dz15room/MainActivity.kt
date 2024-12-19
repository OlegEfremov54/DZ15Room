package com.example.dz15room

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async



@OptIn(DelicateCoroutinesApi::class)
class MainActivity : AppCompatActivity() {
    private lateinit var toolbarMain: Toolbar
    var db: PersonDatabase? = null
    private lateinit var nameET:EditText
    private lateinit var fonET:EditText
    private lateinit var saveBTN:Button
    private lateinit var resaltTV:TextView


    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Инициализация Тулбар
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = " Контакты     ROOM"
        toolbarMain.subtitle = " Вер.1.Главная страница"
        toolbarMain.setLogo(R.drawable.db)

        //Привязываем кнопки
        nameET = findViewById(R.id.nameET)
        fonET = findViewById(R.id.fonET)
        resaltTV = findViewById(R.id.resaltTV)
        saveBTN = findViewById(R.id.saveBTN)

        //Инициируем БД
        db = PersonDatabase.getDatabase(context = this)
        readDataBase(db!!)

    }

    override fun onResume() {
        super.onResume()
        saveBTN.setOnClickListener {
            val name = nameET.text.toString()
            val phone = fonET.text.toString()

            if (name.isNotBlank() && phone.isNotBlank()) {
                val person = Person(name, phone)
                addPerson(db!!, person)
                readDataBase(db!!)
            } else {
                Toast.makeText(this, "Введите имя и телефон!", Toast.LENGTH_SHORT).show()
            }
        }
    }

// Функция добавления персоны
    private  fun addPerson (db:PersonDatabase, person:Person) = GlobalScope.async {
    try {
        db.getPersonDao().insert(person)
        Log.d("MainActivity", "Person added: Name=${person.name}, Phone=${person.fon}")
    } catch (e: Exception) {
        Log.e("MainActivity", "Error adding person: ${e.message}", e)
    }

    }

    private  fun readDataBase(db:PersonDatabase) = GlobalScope.async {
        try {
            val list = db.getPersonDao().getAllPerson()
            Log.d("MainActivity", "Database read: Found ${list.size} persons")
            resaltTV.text = ""
            list.forEach { i ->
                resaltTV.append("${i.name} ${i.fon}\n")
                Log.d("MainActivity", "Person: Name=${i.name}, Phone=${i.fon}")
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "Error reading database: ${e.message}", e)
        }
    }





    // Активация Меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.infoMenuMain -> {
                Toast.makeText(applicationContext, "Автор Ефремов О.В. Создан 17.12.2024",
                    Toast.LENGTH_LONG).show()
            }
            R.id.exitMenuMain ->{
                Toast.makeText(applicationContext, "Работа приложения завершена",
                    Toast.LENGTH_LONG).show()
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}