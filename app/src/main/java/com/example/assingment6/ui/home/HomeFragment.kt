package com.example.assingment6.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assingment6.Adapter.StudentAdapter
import com.example.assingment6.Model.Student
import com.example.assingment6.R
import com.example.assingment6.StudentListData

class HomeFragment : Fragment() {
    private val lstStudents = ArrayList<Student>()
    private lateinit var recyclerView: RecyclerView

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)

        if (StudentListData.get().list().size == 0){
            loadStudents()
        }
        val adapter = StudentAdapter(StudentListData.get().list(),requireContext())
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        return root
    }

    private fun loadStudents() {
        StudentListData.get().list().add(Student(1,"Nitesh","Dhapasi Krishna Mandir",21,"Male"))
        StudentListData.get().list().add(Student(2,"Superem Pandey","Maitidevi",22,"Female"))
        StudentListData.get().list().add(Student(3,"Travis Scoot","Baneswor",20,"Male"))
    }
}