package com.example.SportsBookingSystem.Controller
import com.example.SportsBookingSystem.Entity.MatchEntity
import com.example.SportsBookingSystem.Entity.PlayerMatchLinkEntity
import com.example.SportsBookingSystem.Entity.TeamMatchLinkEntity
import com.example.SportsBookingSystem.Mapper.MatchMapper
import com.example.SportsBookingSystem.Repository.MatchRepository
import com.example.SportsBookingSystem.Rest.Controller.MatchRestController
import com.example.SportsBookingSystem.Service.MatchService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import io.mockk.*
import org.springframework.http.HttpStatus
import java.util.*

class MatchControllerTest {

 private lateinit var matchService: MatchService
 private lateinit var matchController: MatchController

 @BeforeEach
 fun setUp() {
   matchService = mockk()
   matchController = MatchController(matchService)
 }
  @AfterEach
  fun tearDown() {
   clearAllMocks()
  }

  @Test
  fun findAll_then_ReturnAll() {

   val playerMatchLinks = setOf(
    mockk<PlayerMatchLinkEntity>(relaxed = true),
    mockk<PlayerMatchLinkEntity>(relaxed = true)
   )
   val teamMatchLinks = setOf(
    mockk<TeamMatchLinkEntity>(relaxed = true),
    mockk<TeamMatchLinkEntity>(relaxed = true)
   )

   val match = MatchEntity(
    1,
    1,
    "",
    "",
    playerMatchLinks,
    teamMatchLinks
   )

   val updatedMatch = MatchEntity(
    2,
    2,
    "lolThisIsUpdated",
    "",
    playerMatchLinks,
    teamMatchLinks
   )

   val matches = listOf(match, updatedMatch)
   every { matchService.findAllMatches() } returns matches
   val result = matchController.findAll()
   assertEquals(matches, result.body)
   verify { matchService.findAllMatches() }
  }

  @Test
  fun getmatchById_then_returnMatchById() {
   val playerMatchLinks = setOf(
    mockk<PlayerMatchLinkEntity>(relaxed = true),
    mockk<PlayerMatchLinkEntity>(relaxed = true)
   )
   val teamMatchLinks = setOf(
    mockk<TeamMatchLinkEntity>(relaxed = true),
    mockk<TeamMatchLinkEntity>(relaxed = true)
   )

   val match = Optional.of(
    MatchEntity(
     1,
     1,
     "",
     "",
     playerMatchLinks,
     teamMatchLinks
    )
   )
   every { matchService.getmatchById(1) } returns match
   val test = match
   val result = matchController.getmatchById(1)
   assertEquals(match,result.body)
   verify { matchService.getmatchById(1) }
  }

  @Test
  fun findByMatchId() {
    val playerMatchLinks = setOf(
     mockk<PlayerMatchLinkEntity>(relaxed = true),
     mockk<PlayerMatchLinkEntity>(relaxed = true)
    )
    val teamMatchLinks = setOf(
     mockk<TeamMatchLinkEntity>(relaxed = true),
     mockk<TeamMatchLinkEntity>(relaxed = true)
    )

    val match = MatchEntity(
      1,
      1,
      "",
      "",
      playerMatchLinks,
      teamMatchLinks
     )
    every { matchService.findByMatchId(1) } returns match
    val result = matchController.findByMatchId(1)

    assertEquals(match, result.body)
    verify { matchService.findByMatchId(1) }


  }

  @Test
  fun createMatch() {
   val playerMatchLinks = setOf(
    mockk<PlayerMatchLinkEntity>(relaxed = true),
    mockk<PlayerMatchLinkEntity>(relaxed = true)
   )
   val teamMatchLinks = setOf(
    mockk<TeamMatchLinkEntity>(relaxed = true),
    mockk<TeamMatchLinkEntity>(relaxed = true)
   )

   val match = MatchEntity(
    1,
    1,
    "",
    "",
    playerMatchLinks,
    teamMatchLinks
   )
   every { matchService.createMatch(any()) } returns match
   val result = matchController.createMatch(match)
  assertEquals(match,result)
   verify { matchService.createMatch(any()) }
  }

  @Test
  fun updateMatch() {
   val playerMatchLinks = setOf(
    mockk<PlayerMatchLinkEntity>(relaxed = true),
    mockk<PlayerMatchLinkEntity>(relaxed = true)
   )
   val teamMatchLinks = setOf(
    mockk<TeamMatchLinkEntity>(relaxed = true),
    mockk<TeamMatchLinkEntity>(relaxed = true)
   )

   val match = MatchEntity(
    1,
    1,
    "",
    "",
    playerMatchLinks,
    teamMatchLinks
   )

   val updatedMatch = MatchEntity(
    1,
    1,
    "Updated",
    "",
    playerMatchLinks,
    teamMatchLinks
   )

   every { matchService.findByMatchId(1) } returns match
   val result = matchController.findByMatchId(1)
   assertEquals(match, result.body)
   every { matchService.updateMatch(1, any()) } returns updatedMatch
   val result2 = matchController.updateMatch(1, updatedMatch)
   assertEquals(result2.body, updatedMatch)
   verify { matchService.updateMatch(1, any()) }


  }

  @Test
  fun deleteMatch()
  {
   val playerMatchLinks = setOf(
    mockk<PlayerMatchLinkEntity>(relaxed = true),
    mockk<PlayerMatchLinkEntity>(relaxed = true)
   )
   val teamMatchLinks = setOf(
    mockk<TeamMatchLinkEntity>(relaxed = true),
    mockk<TeamMatchLinkEntity>(relaxed = true)
   )

   val match = MatchEntity(
    1,
    1,
    "",
    "",
    playerMatchLinks,
    teamMatchLinks
   )

   every { matchService.deleteMatch(1) } just runs
   val result = matchController.deleteMatch(1)
   assertEquals(HttpStatus.NO_CONTENT, result.statusCode)
   verify { matchService.deleteMatch(1) }

  }
 }
