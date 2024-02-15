package Model.Game

import Model.Card.PropCard
import Model.Card.TrickCard
import Model.Player.Player
import Model.Player.RealPlayer
import Model.Player.VirtualPlayer


class Game {

    val players: MutableList<Player> = createPlayers()

    private val board = Board(theSeventhProp = PropCard.dealCard(players))


    fun startGame() {
        var theOtherHatTrickForfeit = 0
        while (theOtherHatTrickForfeit < 3) {
            players.forEach { player ->


                println()
                println("________________________________________________")
                println("______________   JOUEUR SUIVANT   ______________")
                println("________________________________________________")

                val isSuccess = player.playTour(this, board)

                if (board.getVisibleTrick() == TrickCard.OTHERHATTRICK) {
                    println("dernier tour ! Tentez de marquer The Other Hat Trick")
                    if (isSuccess) {
                        println("${player.name} vient de gagner 6 points ! trop fort le gars !!!")
                        return
                    } else if (theOtherHatTrickForfeit == 2) {
                        println("aucun joueur n'a marqué the other hat trick")
                        stopGame()
                        return
                    } else {
                        println("${player.name} vient de se prendre -3 points dans la tronche ! Dommage !!!")
                        player.score += -3
                        println(theOtherHatTrickForfeit)
                        theOtherHatTrickForfeit++
                    }
                }

            }
        }
    }


    private fun createPlayers(): MutableList<Player> {
        val players = mutableListOf<Player>()
        while (players.size < 3) {
            println("________________")
            println("Entrez le nom d'un joueur  (ou 'IA' pour ajouter un joueur virtuel) :")
            val name = readlnOrNull()

            if (name != null) {
                val player = if (name.equals("IA", ignoreCase = true)) {
                    VirtualPlayer("Joueur IA ")
                } else {
                    RealPlayer(name)
                }
                players.add(player)
            }
        }
        return players
    }

     fun stopGame() {
        println("La partie est terminée")

        println("Voici les scores : ")
        players.forEach { player ->
            println("${player.name} : ${player.score}")
        }
    }

}