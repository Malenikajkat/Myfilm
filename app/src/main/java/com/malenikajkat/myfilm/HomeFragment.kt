package com.malenikajkat.myfilm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val filmsDataBase = listOf(
        Film("1+1", R.drawable.oneplus, "An aristocrat in a wheelchair hires an ex-convict as a nurse. Sparkling French comedy with Omar Si."),
        Film("Interstellar", R.drawable.interstellar, "lm tells the story of the travels of a group of researchers who use a newly discovered space-time tunnel to circumvent the limitations of human flight in space and conquer vast distances on an interstellar ship.."),
        Film("Carried Away by Ghosts", R.drawable.carried, "Chihiro and his mom and dad are moving into a new house. After getting lost on the way, they find themselves in a strange deserted city, where a magnificent feast awaits them. The parents greedily pounce on the food and, to the horror of the girls, turn into pigs, becoming prisoners of the evil sorceress Yubaba. Now, alone among magical creatures and mysterious visions, Chihiro must figure out how to rid her parents of the charms of the insidious old woman."),
        Film("Coco's Secret", R.drawable.coco, "Coco's Secrets tells the story of a twelve-year-old self-taught guitarist. Miguel Rivera, who, despite the strict prohibition of his own family, dreams of following in the footsteps of his long-time idol and becoming a real musician."), Film("Howl's moving castle", R.drawable.castle , "An evil witch cursed 18-year-old Sophie. Now her young soul is in the decrepit body of an old woman, and there is no one nearby who could break the witchcraft spell. In search of a cure for the spell, Sophie finds herself in the walking castle of the wizard Howl, who is served by the demon Calcifer."),
        Film("Hachiko: The most loyal friend", R.drawable.hati, "One day, returning from work, a college professor found a cute Akita Inu puppy at the train station. The professor and Hachiko became loyal friends. Every day the dog saw off and met the owner at the train station."),
        Film("The Matrix Resurrections", R.drawable.matrix, "Game designer Thomas Anderson made a name for himself by working on the Matrix trilogy of games. Although the world around him periodically crashes and exposes his true nature, the former Neo regularly visits a therapist, takes pills and practically convinced himself that all this is a game of his imagination. But one day Bugs, a hacker, comes out to him and offers to follow the white rabbit again."),
        Film("Brest Fortress", R.drawable.fortress, "The story of the heroic defense of the Brest fortress, which took the first blow of the Nazi invaders on June 22, 1941. A story about the three main centers of resistance, led by the regiment commander Peter Gavrilov, Commissar Efim Fomin and the head of the 9th frontier post Andrey Kizhevatov."),
        Film("My neighbor Totoro", R.drawable.totoro, "The sisters Satsuki and Mei move into the village house with their dad. One day, the girls discover that forest guardian spirits live next to them, led by their powerful and kind lord Totoro. Gradually, Totoro becomes a friend of the girls, helping them in their daily adventures."),
        Film("The Little Prince", R.drawable.prince, "The world is impossible without fantasy and adventure. At least this is what the good-natured old aviator believes, in whose neighborhood a very pedantic mother and her diligent daughter recently settled. The girl's life is subject to a strict curriculum, in which time for friends is provided only next summer. However, this carefully constructed plan bursts at the seams when a strange neighbor bursts into the girl's life with his incredible stories about the Little Prince and distant stars. All that remains is to fix the plane, and off we go! This is how the girl's big journey begins - full of dangers, magic, humor and true friendship.")
    )
<<<<<<< HEAD

=======
>>>>>>> e8e86e0 (Modul_31.8 "End")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(home_fragment_root, requireActivity(), 1)

        initSearchView()

        //находим наш RV
        initRecyckler()
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }

    private fun initSearchView() {
        search_view.setOnClickListener {
            search_view.isIconified = false
        }

        //Подключаем слушателя изменений введенного текста в поиска
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            //Этот метод отрабатывает на каждое изменения текста
            override fun onQueryTextChange(newText: String): Boolean {
                //Если ввод пуст то вставляем в адаптер всю БД
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                //Фильтруем список на поискк подходящих сочетаний
                val result = filmsDataBase.filter {
                    //Чтобы все работало правильно, нужно и запроси и имя фильма приводить к нижнему регистру
                    it.title.toLowerCase(Locale.getDefault())
                        .contains(newText.toLowerCase(Locale.getDefault()))
                }
                //Добавляем в адаптер
                filmsAdapter.addItems(result)
                return true
            }
        })
    }

    private fun initRecyckler() {
        main_recycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
    }

}