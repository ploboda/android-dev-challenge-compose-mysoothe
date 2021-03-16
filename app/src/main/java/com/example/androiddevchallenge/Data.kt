/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

class Item(val name: String, val image: Int)

val favoriteItemsData = listOf(
    Item(name = "Short mantras", image = R.drawable.i3560168),
    Item(name = "Stress and anxiety", image = R.drawable.i1557238),
    Item(name = "Overwhelmed", image = R.drawable.i3560044),
    Item(name = "Nature Meditations", image = R.drawable.i3571551),
    Item(name = "Self-massage", image = R.drawable.i1029604),
    Item(name = "Nightly wind down", image = R.drawable.i924824)
)

val bodyItemsData = listOf(
    Item(name = "Inversions", image = R.drawable.i317157),
    Item(name = "Quick yoga", image = R.drawable.i1812964),
    Item(name = "Stretching", image = R.drawable.i4056723),
    Item(name = "Tabata", image = R.drawable.i4662438),
    Item(name = "HILT", image = R.drawable.i999309),
    Item(name = "Pre-natal yoga", image = R.drawable.i396133)
)

val mindItemsData = listOf(
    Item(name = "Meditate", image = R.drawable.i3822622),
    Item(name = "With kids", image = R.drawable.i3094230),
    Item(name = "Aromatherapy", image = R.drawable.i4498318),
    Item(name = "On the go", image = R.drawable.i1241348),
    Item(name = "With pets", image = R.drawable.i4056535),
    Item(name = "High stress", image = R.drawable.i897817)
)
