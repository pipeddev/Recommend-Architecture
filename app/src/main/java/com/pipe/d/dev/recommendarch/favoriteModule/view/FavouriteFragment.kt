package com.pipe.d.dev.recommendarch.favoriteModule.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.pipe.d.dev.recommendarch.BR
import com.pipe.d.dev.recommendarch.common.entities.Wine
import com.pipe.d.dev.recommendarch.common.utils.Constants
import com.pipe.d.dev.recommendarch.common.utils.OnClickListener
import com.pipe.d.dev.recommendarch.common.view.WineBaseFragment
import com.pipe.d.dev.recommendarch.favoriteModule.viewModel.FavoriteViewModel
import com.pipe.d.dev.recommendarch.updateModule.view.UpdateDialogFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

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
class FavouriteFragment : WineBaseFragment(), OnClickListener {

    private val adapter: WineFavListAdapter by inject { parametersOf(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        setupRecyclerView()
        setupObservers()
    }

    private fun setupViewModel() {
        val vm: FavoriteViewModel by inject()

        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
    }

    private fun setupObservers() {
        binding.viewModel?.let {vm ->
            vm.snackBarMsg.observe(viewLifecycleOwner) {resMsg ->
                resMsg?.let { msg -> showMsg(msg)}
            }
            vm.wines.observe(viewLifecycleOwner) {wines ->
                adapter.submitList(wines)
            }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = this@FavouriteFragment.adapter
        }
    }

    private fun showMsg(msgRes: Int) {
        Snackbar.make(binding.root, msgRes, Snackbar.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        binding.viewModel?.onPause()
    }

    /*
    * OnClickListener
    * */
    override fun onFavorite(wine: Wine) {
        (binding.viewModel as? FavoriteViewModel)?.updateFavorite(wine)
    }

    override fun onLongClick(wine: Wine) {
        val fragmentManager = childFragmentManager
        val fragment = UpdateDialogFragment()
        val args = Bundle()
        args.putDouble(Constants.ARG_ID, wine.id)
        fragment.arguments = args
        fragment.show(fragmentManager, UpdateDialogFragment::class.java.simpleName)
        fragment.setOnUpdateListener {
            binding.srlResults.isRefreshing = true
            binding.viewModel?.getAllWines()
        }
    }
}