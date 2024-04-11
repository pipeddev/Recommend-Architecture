package com.pipe.d.dev.recommendarch.loginModule.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.pipe.d.dev.recommendarch.BR
import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.databinding.FragmentLoginBinding
import com.pipe.d.dev.recommendarch.loginModule.viewModel.LoginViewModel
import com.pipe.d.dev.recommendarch.mainModule.view.MainActivity
import org.koin.android.ext.android.inject

/****
 * Project: Wines
 * From: com.cursosant.wines
 * Created by Alain Nicolás Tello on 06/02/24 at 20:23
 * All rights reserved 2024.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * And Frogames formación:
 * https://cursos.frogamesformacion.com/pages/instructor-alain-nicolas
 *
 * Coupons on my Website:
 * www.alainnicolastello.com
 ***/
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        setupObservers()
    }

    private fun setupViewModel() {
        val vm: LoginViewModel by inject()
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
    }

    private fun setupObservers() {
        binding.viewModel?.let {vm ->
            vm.snackBarMsg.observe(viewLifecycleOwner) {resMsg ->
                resMsg?.let { showMsg(resMsg) }
            }
            vm.isValidAuth.observe(viewLifecycleOwner) { isValid ->
                if(isValid) closeLoginUI()
            }
        }
    }

    /*private fun setupButtons() {
        with(binding) {
            btnLogin.setOnClickListener {
                vm.login(etUsername.text.toString(), etPin.text.toString())
            }
        }
    }*/

    private fun showMsg(msgRes: Int) {
        Snackbar.make(binding.root, msgRes, Snackbar.LENGTH_SHORT).show()
    }

    private fun closeLoginUI() {
        (requireActivity() as MainActivity).setupNavView(true)
        requireActivity().supportFragmentManager.beginTransaction().apply {
            remove(this@LoginFragment)
                .commit()
        }
    }

    override fun onPause() {
        super.onPause()
        binding.viewModel?.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}