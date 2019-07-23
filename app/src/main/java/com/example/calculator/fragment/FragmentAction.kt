package com.example.calculator.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import com.example.calculator.R
import kotlinx.android.synthetic.main.fragment_fragment_action.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FragmentAction.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FragmentAction.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FragmentAction : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var btn0: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_action, container, false)
        //references
        val btn0 = view.findViewById<Button>(R.id.btn0)
        val btn1 = view.findViewById<Button>(R.id.btn1)
        val btn2 = view.findViewById<Button>(R.id.btn2)
        val btn3 = view.findViewById<Button>(R.id.btn3)
        val btn4 = view.findViewById<Button>(R.id.btn4)
        val btn5 = view.findViewById<Button>(R.id.btn5)
        val btn6 = view.findViewById<Button>(R.id.btn6)
        val btn7 = view.findViewById<Button>(R.id.btn7)
        val btn8 = view.findViewById<Button>(R.id.btn8)
        val btn9 = view.findViewById<Button>(R.id.btn9)
        val btnAC = view.findViewById<Button>(R.id.btnClear)
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val btnPercent = view.findViewById<Button>(R.id.btnPercent)
        val btnDivide = view.findViewById<Button>(R.id.btnDivide)
        val btnMulti = view.findViewById<Button>(R.id.btnMul)
        val btnPlus = view.findViewById<Button>(R.id.btnPlus)
        val btnMinus = view.findViewById<Button>(R.id.btnMinus)
        val btnDot = view.findViewById<Button>(R.id.btnDot)
        val btnEqual = view.findViewById<Button>(R.id.btnEqual)
        //numbers
        btn0?.setOnClickListener { listener?.onClickBtn("0") }
        btn1?.setOnClickListener { listener?.onClickBtn("1") }
        btn2?.setOnClickListener { listener?.onClickBtn("2") }
        btn3?.setOnClickListener { listener?.onClickBtn("3") }
        btn4?.setOnClickListener { listener?.onClickBtn("4") }
        btn5?.setOnClickListener { listener?.onClickBtn("5") }
        btn6?.setOnClickListener { listener?.onClickBtn("6") }
        btn7?.setOnClickListener { listener?.onClickBtn("7") }
        btn8?.setOnClickListener { listener?.onClickBtn("8") }
        btn9?.setOnClickListener { listener?.onClickBtn("9") }
        btnDot?.setOnClickListener { listener?.onClickBtn(".") }
        //Operators
        btnAC?.setOnClickListener { listener?.onClickBtn("clear") }
        btnBack?.setOnClickListener { listener?.onClickBtn("back") }
        btnPercent?.setOnClickListener { listener?.onClickBtn("%") }
        btnDivide?.setOnClickListener { listener?.onClickBtn("/") }
        btnMinus?.setOnClickListener { listener?.onClickBtn("-") }
        btnPlus?.setOnClickListener { listener?.onClickBtn("+") }
        btnMulti?.setOnClickListener { listener?.onClickBtn("*") }
        btnEqual?.setOnClickListener { listener?.onClickBtn("=") }
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
        fun onClickBtn(str: String)
    }
}
