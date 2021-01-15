package com.example.assingment6.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.assingment6.Model.Student
import com.example.assingment6.R
import com.example.assingment6.StudentListData
import com.example.assingment6.communicator
import com.example.assingment6.ui.home.HomeFragment

class DashboardFragment : Fragment() {
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etAddress: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var btnSave: Button
    private lateinit var male: RadioButton
    private lateinit var female: RadioButton
    private lateinit var other: RadioButton
    private val lstStudents = ArrayList<Student>()
    private var i = 4
    private var selectedGender = ""
    private lateinit var communicator: communicator

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        etName = root.findViewById(R.id.etName)
        etAge = root.findViewById(R.id.etAge)
        etAddress = root.findViewById(R.id.etAddress)
        radioGroup = root.findViewById(R.id.radioGroup)
        btnSave = root.findViewById(R.id.btnSave)
        male = root.findViewById(R.id.male)
        female = root.findViewById(R.id.female)
        other = root.findViewById(R.id.other)

        //communicator = activity as Communicator

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            selectedGender = when (checkedId) {
                R.id.male -> {
                    male.text.toString()
                }
                R.id.female -> {
                    female.text.toString()
                }
                R.id.other -> {
                    other.text.toString()
                }
                else -> {
                    ""
                }
            }
        }

        btnSave.setOnClickListener {
            StudentListData.get().list().add(Student(i++,etName.text.toString(),etAddress.text.toString(),etAge.text.toString().toInt(),selectedGender))
            //communicator.passData(lstStudents)
            val bundle = Bundle()
            bundle.putString("listData","passedData")
            HomeFragment().arguments = bundle
            Toast.makeText(activity, "Student Added!!", Toast.LENGTH_LONG).show()

        }



        return root
    }
}