package me.hammer86gn.djar.api.object;

import me.hammer86gn.djar.api.DJAR;

import java.net.URL;

/**
 *
 * Object that allows for interaction with Discord's Guilds or as they are more commonly called Servers
 *
 */
public interface Guild {

    /**
     * Get the id of the <b>Guild</b>
     *
     * @return - {@link Long}
     */
    long getGuildID();

    /**
     * Does the same as {@link Guild#getGuildID} but converts to a string
     *
     * @return {@link String}
     */
    String getGuildIDAsString();

    /**
     * Get the name of the <b>Guild</b> <p>Through a <a href="https://en.wikipedia.org/wiki/Representational_state_transfer">REST Request</a></p>
     *
     *
     * @return {@link String}
     */
    String getGuildName();

    /**
     * Get the <b>Guild</b> owner's user id
     *
     * @return {@link Long}
     */
    long getGuildOwnerID();

    /**
     * Gets the <b>Guild</b> icon
     *
     * @return {@link String}
     */
    String getGuildIcon();

    /**
     * Does the same as {@link Guild#getGuildIconURL} but converts it to a URL
     *
     * @return {@link URL}
     */
    URL getGuildIconURL();

    /**
     * Gets the Region the <b>Guild</b>
     *
     * @return {@link String}
     */
    String getGuildRegion();

    /**
     * Change the name of the <b>Guild</b>
     *
     * @param name {@link String} what to change the <b>Guild</b> name to
     */
    void changeGuildName(String name);

    DJAR getDJAR();

}
