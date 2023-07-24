package com.feature.ui.navigation.screen

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@Composable
fun MovieScreen(
    viewModel: MovieViewModel,
    navHostController: NavHostController
){
    val result = viewModel.movieScreenState.collectAsState().value
    val query = viewModel.query.collectAsState().value

    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Scaffold(
        topBar = {
            TextField(
                value = query,
                onValueChange = { viewModel.setSearchQuery(it) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    backgroundColor = Color.Transparent
                ),
                placeholder = {
                    Text(text = "Search Movie..")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
            )
        }
    ) { paddingValues ->
        Log.d("TAG", "MovieScreen: $paddingValues")
        if(result.isLoading){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
        result.errorMessage?.let {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text = it)
            }
        }
        result.movieList?.let {
            if(it.isEmpty()){
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text(text = "Nothing Found")
                }
            }else{
                LazyVerticalGrid(columns = GridCells.Adaptive(minSize = screenWidth/3), content = {
                    items(it){
                        Box(modifier = Modifier
//                            .height(200.dp)
                            .border(width = 1.dp, color = Color.White)
                        ){
                            AsyncImage(
                                modifier=Modifier.clickable {
//                                    navController.navigate("movie_details/${it.id}")
                                },
                                model = it.imageUrl,
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                            )
                        }
                    }
                })
            }
        }


    }

}